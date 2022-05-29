package ma.servicessanitaires.exceptions;

import ma.servicessanitaires.entities.Medicament;

public class MedicamentNotFoundException extends Exception{
    public MedicamentNotFoundException(String mssg){super(mssg);}
}
