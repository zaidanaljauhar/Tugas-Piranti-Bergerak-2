<?php
// File: app/Config/Routes.php (append the following routes inside $routes closure)
$routes->get('/', 'Home::index');
$routes->post('add-staff', 'ServerApi::addStaff');
$routes->get('get-staff', 'ServerApi::getDataStaff');
$routes->post('delete-staff', 'ServerApi::deleteStaff');
$routes->post('update-staff', 'ServerApi::updateStaff');
