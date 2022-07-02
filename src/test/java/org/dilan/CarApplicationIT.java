package org.dilan;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith( SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarApplicationIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getsAllCars() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getsSingleCar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnsNotFoundForInvalidSingleCar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/car/4")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void addsNewCar() throws Exception {
        String newCar = "{\"name\":\"gallardo\",\"make\":\"Lamborghini\",\"mileage\":1250,\"numberOfDoors\":2}";
        mockMvc.perform(MockMvcRequestBuilders.post("/car")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newCar)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}
