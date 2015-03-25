# Agave Tags API Mock Server

This is a simple mock server of the Agave Tags API built using the [Minnal](http://minnal.github.io/minnal/index.html) framework. It has full persistence via JPA, Hibernate validation, serialization to JSON via Jackson, and is ready to kick around out of the box.

It does **NOT** yet have custom serialization to add hypermedia links, OAuth support, or sufficient validation. Those can all be added with a small bit of work in a few hours. This was simply a quick example of how to create a trivial app using Minnal.

## Takeaways
* Minnal makes it significantly easier to get a working draft up than either with DropWizard or Restlet.
* The persistence issues that always pop up in Java are still here. The exclusive use of JPA makes some things easier, but for more complicated domain models, the effort is basically the same.
* Authz is very clean and pluggable in this framework, as is Authn.
* Serialization is lightning fast.
* The ability to perform built in filter queries and lack of need for DAO is a **HUGE** win. This is a nightmare to do in other frameworks.
* The generators do save quite a bit of time, but are not yet as helpful as their counterparts in PHP.
* The auto-generated unit tests are a huge time saver for validating the domain and APIs work as expected.
* This is probably better suited for CRUD heavy APIs rather than process-oriented APIs. In all fairness, a strong argument can be made that you should only be handling CRUD and event creation at the API layer anyway. Heavier tasks should be done async with their state and status exposed through other API.



## Installation

```bash
git clone https://github.com/deardooley/agave-tags-minnal-framework.git  
cd agave-tags-minnal-framework
mvn clean install
```

## Running

```bash
mvn exec:exec
```

The API will be available at:

> [http://localhost:8080/tags](http://localhost:8000/tags)  

You can view the available routes at:

> [http://localhost:8080/admin/routes/tags](http://localhost:8080/admin/routes/tags)  

To view and interact with the API documentation, use the hosted [Swagger Editor](http://editor.swagger.io/#/) provided by Reverb and either paste the contents of the `tags.yaml` file into the editor.
