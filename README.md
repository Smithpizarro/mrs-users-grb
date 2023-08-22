# mrs-users-grb
We want a function in the company to show the price list, we have the PRICES table that reflects the final price (pvp), the brandId that is the identifier of the group chain and the rate that applies to a product of a chain between certain dates.
You want to build a service in SpringBoot that provides a query rest end point such that:
 
Accept as input parameters: application date, product identifier,  identifier brand.
Return as output data: product identifier, brand identifier, rate to apply, application dates and final price to apply.

**Create a Spring boot application that exposes the agreed REST API on port 8092.**

![Diagram](./src/main/resources/diagram_products.jpg "Diagram")

## Testing and Self-evaluation
You can run in your tool of application executing the bean MrsProductsGrbApplication.
Check that mocks are working with a sample request to:
http://localhost:8092/products/prices.

http://localhost:8092/products/prices?productCode=35455&brandId=1&aplicationDate=2021-06-14 16:00.
