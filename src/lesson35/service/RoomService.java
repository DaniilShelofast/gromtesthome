package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.dao.RoomDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Filter;
import lesson35.model.Room;

import java.util.LinkedList;
import java.util.List;

import static lesson35.service.ValidationUtils.checkContentAndNull;


public class RoomService {

    public final RoomDAO roomDAO = new RoomDAO();
    public final HotelDAO hotelDAO = new HotelDAO();

    public List<Room> findRooms(Filter filter) throws Exception {
        List<Room> rooms = new LinkedList<>();

        if (checkNull(filter)) {
            return roomDAO.readAll();
        } else {
            for (Room room : roomDAO.readAll()) {
                if (matchesFilter(room, filter)) {
                    rooms.add(room);
                }
            }
        }
        return rooms;

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

    private void validateFilter(Filter filter) throws Exception {
        if (filter.getNumberOfGuests() <= 0 || filter.getPrice() <= 0 || filter.getDateAvailableFrom() == null
                || checkContentAndNull(filter.getCountry()) || checkContentAndNull(filter.getCity()) || filter.getHotel() == null) {
            throw new BadRequestException("Error, the entered data is incomplete, fill in each specified field.");
        }
    }

    private boolean matchesFilter(Room room, Filter filter) {
        return ((Integer) room.getNumberOfGuests()).equals(filter.getNumberOfGuests()) || ((Double) room.getPrice()).equals(filter.getPrice())
                || (Boolean) room.isBreakfastIncluded() == filter.isBreakfastIncluded() || (Boolean) room.isPetsAllowed() == filter.isPetsAllowed() ||
                room.getDateAvailableFrom().equals(filter.getDateAvailableFrom())
                || room.getHotel().getCountry().equals(filter.getCountry()) || room.getHotel().getCity().equals(filter.getCity())
                || room.getHotel().getName().equals(filter.getHotel());
    }

    private boolean checkNull(Filter filter) {
        return filter.getNumberOfGuests() == null && filter.getPrice() == null && filter.isBreakfastIncluded() == null && filter.isPetsAllowed() == null &&
                filter.getDateAvailableFrom() == null && filter.getCountry() == null && filter.getCity() == null && filter.getHotel() == null;
    }
}
