# tiny-url

Problem: https://leetdesign.com/problems/tiny-url

# Solution

Web API with 2 endpoints:

- create short link (`POST /`)
- access short link (`GET /:id`)

Information about the shorted link is persisted in a Redis instance for 5 years