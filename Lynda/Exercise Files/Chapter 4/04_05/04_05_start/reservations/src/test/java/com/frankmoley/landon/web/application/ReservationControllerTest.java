package com.frankmoley.landon.web.application;

import com.frankmoley.landon.business.domain.RoomReservation;
import com.frankmoley.landon.business.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @MockBean
    private ReservationService reservationService;
    @Autowired
    private MockMvc mockMvc;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void getReservation() throws Exception{
        Date date = DATE_FORMAT.parse("2017-01-01");
        List<RoomReservation> mockReservationList = new ArrayList<>();
        RoomReservation mockRooReservation = new RoomReservation();
        mockRooReservation.setLastName("Test");
        mockRooReservation.setFirstName("JUnit");
        mockRooReservation.setDate(date);
        mockRooReservation.setGuestId(1);
        mockRooReservation.setRoomNumber("J1");
        mockRooReservation.setRoomId(100);
        mockRooReservation.setRoomName("JUnit Room");
        mockReservationList.add(mockRooReservation);

        given(reservationService.getRoomReservationsForDate(date)).willReturn(mockReservationList);
        mockMvc.perform(get("/reservations?date=2017-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test, JUnit")));

    }
}
