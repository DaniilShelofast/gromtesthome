package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.dao.RoomDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Filter;
import lesson35.model.Room;

import java.util.LinkedList;
import java.util.List;


public class RoomService {

    public final RoomDAO roomDAO = new RoomDAO();
    public final HotelDAO hotelDAO = new HotelDAO();

    public List<Room> findRooms(Filter filter) throws Exception {
        List<Room> list = new LinkedList<>();

        nullRoom(filter);

        for (Room room : roomDAO.readAll()) {
            if (room.getNumberOfGuests() == filter.getNumberOfGuests() || room.getPrice() >= filter.getPrice() || room.isBreakfastIncluded() == filter.isBreakfastIncluded() || room.isPetsAllowed() == filter.isPetsAllowed() ||
                    room.getDateAvailableFrom().equals(filter.getDateAvailableFrom()) || room.getHotel().getCountry().equals(filter.getCountry()) || room.getHotel().getCity().equals(filter.getCity()) || room.getHotel().getId() == filter.getHotel().getId()) {
                list.add(room);
            }
        }
        return list;
    }

    public void addRoom(Room room) throws Exception {
        validateRoom(room);
        roomDAO.addObjectToFile(room);
    }

    public void deleteRoom(long idRoom) throws Exception {
        roomDAO.findObject(idRoom);
        roomDAO.deleteObjectFromFile(idRoom);
    }


    private void validateRoom(Room room) throws Exception {
        if (room.getNumberOfGuests() <= 0 || room.getPrice() <= 0 || room.getDateAvailableFrom() == null || room.getHotel() == null) {
            throw new BadRequestException("Error, the entered data is incomplete, fill in each specified field.");
        }
        hotelDAO.findObject(room.getHotel().getId());
    }

    private void nullRoom(Filter filter) throws BadRequestException {
        if (filter.getHotel() == null) {
            throw new BadRequestException("error");
        }
    }


}
