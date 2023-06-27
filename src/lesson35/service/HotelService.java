package lesson35.service;

import lesson35.dao.HotelDAO;
import lesson35.exception.BadRequestException;
import lesson35.model.Hotel;

import static lesson35.dao.HotelDAO.readFileTextHotel;
import static lesson35.dao.HotelDAO.recordObjectHotel;

public class HotelService extends GeneralService<Hotel> {


    public static Hotel findHotelByCity(String city) throws Exception {
        for (Hotel hotel : recordObjectHotel(readFileTextHotel())) {
            if (hotel.getCity().equals(city)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public static Hotel findHotelByName(String name) throws Exception {
        for (Hotel hotel : recordObjectHotel(readFileTextHotel())) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        throw new BadRequestException("Error : this city is not in our database.");
    }

    public static void addHotel(Hotel hotel) throws Exception {
        HotelDAO hotelDAO = new HotelDAO();
        HotelService hotelService = new HotelService();
        hotelService.verificationObjectID(hotel.getId());
        hotelDAO.addObjectToFile(hotel);
    }

    public static void deleteHotel(long idHotel) throws Exception {
        HotelDAO hotelDAO = new HotelDAO();
        hotelDAO.deleteObjectFromFile(idHotel);
    }

    @Override
    protected boolean verificationObjectID(long id) throws Exception {
        setReadFile(recordObjectHotel(readFileTextHotel()));
        return super.verificationObjectID(id);
    }

    @Override
    public Hotel findIdObject(long id) throws Exception {
        setReadFile(recordObjectHotel(readFileTextHotel()));
        return super.findIdObject(id);
    }

}
