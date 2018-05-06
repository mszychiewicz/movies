# movies
Basic SpringBoot REST application.

Aplikacja umożliwia:
- pobranie listy filmów
- pobranie szczegółów jednego filmu
- dodanie filmu

W aplikacją utworzeni są prekonfigurowani użytkownicy.
Przykładowe komendy dla użytkownika jbutton:
- pobranie listy filmów:
  curl -X GET http://localhost:8080/jbutton/movies/
- pobranie szczegółów jednego filmu:
  curl -X GET http://localhost:8080/jbutton/movies/2
- dodanie filmu:  
  curl -X POST http://localhost:8080/jbutton/movies/ -H "Content-Type: application/json" -d '{"title": "Blade Runner","description": "A movie description"}'

Do RESTowego kontrolera utworzone są także testy jednostkowe.
