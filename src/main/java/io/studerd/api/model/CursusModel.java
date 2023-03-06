package io.studerd.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CursusModel {
     private String CursusTitle;
     private String CursusDescription;
     private UUID Cursus_id;
}
