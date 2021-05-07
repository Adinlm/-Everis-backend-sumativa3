import { FormControl, ValidationErrors } from '@angular/forms';

export class Luv2ShopValidators {

    // valida espacio en blanco
    static notOnlyWhitespace(control: FormControl) : ValidationErrors {
        
        // chequea s el string solo tiene espacios en blanco
        if ((control.value != null) && (control.value.trim().length === 0)) {

            // invalido, retorna objeto del error
            return { 'notOnlyWhitespace': true };
        }
        else {
            // valdio, retorna null
            return null;
        }
    }
}
