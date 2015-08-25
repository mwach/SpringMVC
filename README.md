# SpringMVC
sample spring mvc app
init


How to test REST service:

GET:
curl http://localhost:8080/SpringMVC/contact
POST
curl-i -X POST -H "Content-Type:application/json" -d '{  "name" : "Frodo" }' http://localhost:8080/SpringMVC/contact
