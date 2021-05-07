import { Component, OnInit } from '@angular/core';
import { OktaAuthService } from '@okta/okta-angular';

@Component({
  selector: 'app-login-status',
  templateUrl: './login-status.component.html',
  styleUrls: ['./login-status.component.css']
})
export class LoginStatusComponent implements OnInit {

  isAuthenticated: boolean = false;
  userFullName: string;

  storage: Storage = sessionStorage;

  constructor(private oktaAuthService: OktaAuthService) { }

  ngOnInit(): void {

    // Suscribirse a los cambios de estado de autenticación
    this.oktaAuthService.$authenticationState.subscribe(
      (result) => {
        this.isAuthenticated = result;
        this.getUserDetails();
      }
    );
    
  }

  getUserDetails() {
    if (this.isAuthenticated) {

      // Obtener los detalles del usuario que inició sesión (reclamos del usuario)
      //
      // El nombre completo del usuario se expone como un nombre de propiedad.
      this.oktaAuthService.getUser().then(
        (res) => {
          this.userFullName = res.name;

          // recuperar el correo electrónico del usuario de la respuesta de autenticación
          const theEmail = res.email;

          // ahora almacena el correo electrónico en el almacenamiento del navegador
          this.storage.setItem('userEmail', JSON.stringify(theEmail));
        }
      );
    }
  }

  logout() {
    // Termina la sesión con Okta y elimina los tokens actuales.
    this.oktaAuthService.signOut();
  }
}
