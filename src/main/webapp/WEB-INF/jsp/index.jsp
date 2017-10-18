<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<br><br>For admins:
<br>GET /rest/admin/restaurants - get all restaurants
<br>POST /rest/admin/restaurants - create new restaurant
<br>DELETE /rest/admin/restaurants/{id} -  delete restaurant with id={id}
<br><br>GET /rest/admin/restaurants/by?name={name} -  get restaurant with name={name}

<br>GET /rest/admin/users - get all users
<br>POST /rest/admin/users - create new user
<br>DELETE /rest/admin/users/{id} -  delete user with id={id}
<br>PUT /rest/admin/users -  update user
<br>GET /rest/admin/users/by?email={email} - get user with email={email}

<br>GET /rest/admin/menus - get all menus
<br>POST /rest/admin/menus - create new menu
<br>DELETE /rest/admin/menus/{id} -  delete menu with id={id}
<br>PUT /rest/admin/meals -  update dish with id={id}
<br>GET /rest/admin/menus/by/date - get all menus by date
<br>GET /rest/admin/menus/by/restaurant?name={name} - get all menus by restaurant wit name={name}

<br>GET /rest/admin/meals/by/menu_id/{restaurant_name}?menu_id={menu_id} - get all dishes in menu with {id} from restaurant with name={name}
<br>POST /rest/admin/meals - create new meal
<br>DELETE /rest/admin/meals/{id} -  delete dish with id={id}
<br>PUT /rest/admin/meals -  update dish

<br><br>GET /votes - get history of user votes
<br>GET /votes?sort={asc}/{desc} - get history of user votes in descending or ascending order (default is descending)
<br>GET /votes?date={date} - get history of user votes filtered by date (in format "yyyy-MM-dd")
<br>GET /votes?restaurantName={name} - get history of user votes filtered by restaurant
<br>GET /votes?userId={id} - get history of user votes filtered by user

<br><br>
For users:
<br>GET /rest/profile/restaurants - get restaurants
<br>GET /rest/profile/vote - get today's user vote for current user
<br>DELETE /rest/profile/vote - delete today's user vote for current user
<br>PUT /rest/profile/vote - change today's user vote for current user
<br>POST /rest/profile/vote - create today's user vote for current user
<br><br>
<a href="j_spring_security_logout">logout </a>
</body>
</html>
