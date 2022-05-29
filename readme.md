# BLOGS APP

### Reference Documentation

## Application Details:

#### Database
Using Derby database for on fly (single time app), same configurations works with Postrges as tested locally.
We have three tables 
1. **User** (Employee was used to avoid confusion on User class from spring security) : Contains user details 
with id, name, password, role, etc.
2. **Blog**: It contains blog details and date time of creation for sorting in later stage.
3. **Role**: Used to assign different roles to any user. i.e. Admin, SuperAdmin, Reader

Have added sample blogs and sample users for default use case.

#### APIs

PFA postman collection for reference of APIs used for serving forntend app.

## Heroku deployment:
url : 

    https://blog-springboot-suyash.herokuapp.com/

Command:

    git push heroku master
