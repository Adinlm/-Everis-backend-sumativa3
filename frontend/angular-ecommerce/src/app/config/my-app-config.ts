export default {

    oidc: {
        clientId: '0oapaqdcymCgzvti95d6',
        issuer: 'https://dev-22310141.okta.com/oauth2/default',
        redirectUri: 'http://localhost:4200/login/callback',
        scopes: ['openid', 'profile', 'email']

    /**
     * connfiguracion de Okta User/registrationng serve
  * openid: requerido para la authentication request
  * profile: firstname, lastname, phone, y todo eso
  * email: email del user.
  */
    }

}