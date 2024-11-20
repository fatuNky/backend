# Task 2: Add Swagger Documentation to the CategoryController

## Objective
Enhance the `CategoryController` by adding Swagger annotations to provide clear and interactive API documentation for the CRUD operations on the `Category` entity.

---

## What You Need to Do

1. **Open the `CategoryController`** class from Task 1.

2. **Annotate the Controller**:
    - Add `@Tag` at the class level to provide a description for the Category API group.
    - Use `@Operation` for each method to describe the endpoint's purpose.

3. **Describe Parameters and Responses**:
    - Use `@Parameter` to explain request parameters like `id`.
    - Add `@ApiResponse` annotations to document possible HTTP responses (e.g., `200 OK`, `404 Not Found`).

4. **Run and Verify**:
    - Start the application and open Swagger UI (e.g., `http://localhost:8080/swagger-ui/`).
    - Ensure the Category endpoints are fully documented and displayed correctly.
