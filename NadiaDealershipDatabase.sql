SELECT dealerships.*
FROM dealerships
JOIN inventory ON dealerships.dealership_id = inventory.dealership_ID
WHERE inventory.VIN = '12345';