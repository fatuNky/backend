# Task 3: Write Integration Tests for CRUD Operations

## Objective
In this task, you will write integration tests for the CRUD operations of the `Category` API using `MockMvc` and, as an additional challenge, using `RestAssured` instead of JsonPath.

---

## What You Need to Do

1. **Set up Integration Test Class**
    - Create a test class for the `CategoryController` with `@SpringBootTest` and `@AutoConfigureMockMvc`.

2. **Write Tests for Each Endpoint**
    - **POST `/api/categories`**: Test creating a new category and check if the response status is `201 Created`.
    - **GET `/api/categories`**: Test retrieving all categories and ensure it returns a list with a `200 OK` status.
    - **GET `/api/categories/{id}`**: Test retrieving a category by ID and check if the returned category data matches.
    - **PUT `/api/categories/{id}`**: Test updating a category and verify the changes are reflected.
    - **DELETE `/api/categories/{id}`**: Test deleting a category and verify the `204 No Content` response.

3. **Use `MockMvc` to Perform HTTP Requests**
    - Use `MockMvc` to perform the HTTP requests and check the response status and content with assertions like `status().isCreated()`, `jsonPath()`, etc.

##  Challenge (Optional): Use RestAssured
    - Instead of using `jsonPath()` for verifying the response body, replace it with `RestAssured` to perform the assertions.