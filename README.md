## Work with users:

# Get list of user:
http://localhost:8080/rest/user

# Get user by id:
http://localhost:8080/rest/user/1

## Work with restaurants:

# Get list of restaurants:
http://localhost:8080/rest/restaurant

# Get restaurant by id:
http://localhost:8080/rest/restaurant/1

# Add new restaurant:
-X POST 'http://localhost:8080/rest/restaurant' -H 'Content-Type: application/json' -d '{"name" : "York"}'


