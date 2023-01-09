package com.inventorycontrol.http.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class EntryRequest {

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:MM")
    private LocalDateTime requestDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:MM")
    private LocalDateTime entryDate;

    private Double total;

    private Double shipping;

    private Integer invoiceNumber;

    private Double tax;
}
