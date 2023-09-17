# Sales Sample

This service provides an endpoint to query product prices for a given brand, product, and date. The service is
implemented using Spring Boot and uses a persistent H2 database.

## Database

The application uses an H2 local persisted database to store brands and product prices. The database schema and initial
data can be found in `V1__initialize_price_brand_schema` script.

## Endpoints

### POST `/api/v1/prices/search`

Searches for a product's price for a given brand and date.

**Request Payload:**

```json
{
  "brandId": 1,
  "productId": 35455,
  "applyDate": "2020-06-16T21:00:00"
}
```

**Response Payload:**

```json
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 4,
  "startDate": "2020-06-15T16:00:00",
  "endDate": "2020-12-31T23:59:59",
  "price": 38.95
}
```

**Error response:**

```json
{
  "timestamp": "2023-09-17T12:06:18.570485",
  "status": 400,
  "error": "Bad Request",
  "message": ""
}
```

## Running the application

To run the application, you need to have Maven and Java installed.

Run the application using Maven:

```bash
./mvnw spring-boot:run
```

The application should now be running and accessible at http://localhost:8080/.

## Running Integration Tests

The integration tests are located in the `PriceIntegrationTest` file.

To run the tests:

```bash
./mvnw test
```

## Additional Test Cases

Further test cases can be added in the `prices_test_cases.csv` file. Ensure to follow the existing format and add test
scenarios as needed.

```csv
"applyDate","price"
"2020-06-14T10:00:00", 35.5,
"2020-06-14T16:00:00", 25.45,
"2020-06-14T21:00:00", 35.5,
"2020-06-15T10:00:00", 30.5,
"2020-06-16T21:00:00", 38.95
```