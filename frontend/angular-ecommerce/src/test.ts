// Este archivo es requerido por karma.conf.js y carga recursivamente todos los archivos .spec y framework.

import 'zone.js/dist/zone-testing';
import { getTestBed } from '@angular/core/testing';
import {
  BrowserDynamicTestingModule,
  platformBrowserDynamicTesting
} from '@angular/platform-browser-dynamic/testing';

declare const require: any;

// Primero, inicia el entorno de prueba angular.
getTestBed().initTestEnvironment(
  BrowserDynamicTestingModule,
  platformBrowserDynamicTesting()
);
// Luego encontramos todas las pruebas.
const context = require.context('./', true, /\.spec\.ts$/);
// Y carga los módulos
context.keys().map(context);
