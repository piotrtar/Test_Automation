
var request = require("request");
const baseURL = "https://jsonplaceholder.typicode.com/posts/";
const userURL = "https://jsonplaceholder.typicode.com/posts/1"

describe("REST API Test", () => {

    const mockEmployee =
    {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    }

    it("Should return status code 200", (done) => {
        request.get(baseURL, (error, response, body) => {
            expect(response.statusCode).toBe(200);
            done();
        });
    });

    it("Should return users with id=5", (done) => {
        request.get(userURL, (error, response, body) => {
            expect(JSON.parse(body)).toEqual(mockEmployee)
            done();
        });
    });

    it("Should return statys 201", (done) => {
      request.post(baseURL, mockEmployee, (error, response, body) => {
          expect(response.statusCode).toBe(201);
          done();
      });
  });
});