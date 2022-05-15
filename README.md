# TEST_ING

For running the application just clone the application and start the application. It will automatically starts in 8080 port.

**Curl for Adding Apple Bag:**
curl --location --request POST 'http://localhost:8080/api/v1/applebag/add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "quantity": 2,
    "supplierName": "Royal Gala",
    "date": "2022-05-15T21:43:10.249782",
    "priceOfBag": 10
}'

**Curl for getting Apple Bags** (just pass the noOfBags in params by default it will take 3
curl --location --request GET 'http://localhost:8080/api/v1/applebags?noOfBags=2' \
--data-raw ''
