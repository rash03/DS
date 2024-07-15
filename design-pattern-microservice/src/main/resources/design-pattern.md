**Pattern for Microservice**
- APi Gateway Pattern
  - Acts as a reverse proxy to route requests from clients to the appropriate microservices.
- Aggregator Pattern
  - Used to aggregate responses from multiple microservices into a single response
- Proxy Pattern
  - Similar to the API Gateway, but usually implemented as a lightweight proxy.
- Database per service Pattern
  - Each microservice has its own database to ensure loose coupling and autonomy.
- Event Sourcing Pattern
  - Instead of storing the current state of the data, all changes to the application state are stored as a sequence of events
  - Ways to store events
    - Database
    - Message Broker
    - Benefit : Higher write performance (for write intensive workloads) 
    - Event sourcing replaying events
      - By taking snapshots OR
      - Powerfull combination - Event Sourcing + CQRS . But it garuntees only eventual consistency. It provides
        - Auditing
        - Performant writes
        - efficient Reads
- Command Query Responsibility Segregation (CQRS) Pattern
  - Separates the read and write operations on a data model into two distinct models.
    - Command - action we perform that results in data mutation - Add/ update / delete operations
    - Query - only reads data and returns to caller
    - usefull for system where there are frequent writes and frequent reads, but reads involves data from different places / complex queries etc.
    - Business Logic goes to Command service which connects to a Db suited for its action (Optimal schema for writes) and Query Service connects to a DB (like no sql)
    which is optimized for reads (Optimal schema for reads).
    Data is duplicated between command Db and Query Db as required. Note : A review schema can be created using Review, user, product and order table
    This review schema becomes part of query service. Every time a review is updated in command service, a event is generated and query service updates
    its view. The quesry service can also have a Product rating view. This view does not need to update everytime command service is hit. hence it can 
    be updated like afer every hour or so. 
    This provides higher scalability. 
    How to synchrionize the DB ?. 
      - 1. By message Broker:  Publish an event when Command service is hit. Use message broker b/w command and query service. make sure to use 
      Transaction outbox pattern in this case as well. 
      - 2. By Function as a service: it can be a cloud function which gets triggered when DB is modified, and executes custom code to update the
      Query DB.
    - Issues :
      - Only Eventual Consistency can be guarantee. This pattern shuold not be used for Strict Consistency.
      - Adds overheads and complexity
- Circuit Breaker Pattern
  - Prevents a network or service failure from cascading to other services.
- Saga Pattern
  - Manages distributed transactions across multiple microservices, ensuring consistency and rollback capabilities.
  - https://www.baeldung.com/cs/saga-pattern-microservices
  - https://camel.apache.org/components/4.4.x/eips/saga-eip.html
  - https://portx.io/saga-based-design-using-apache-camel-and-kafka-implementing-highly-reliable-distributed-business-transactions/
  - TODO Sample service for Saga
- Transaction Out box Pattern - Reliability in Event Driven Architecture.
- Materialized View Pattern
  - One or more source table which act as a source of truth - usecase is related to scenario in same Database, where a view is created using
  using complext queires on more than one table of that DB.
    - pre compute and pre populate a separate table with results of particular queries (quires that work on large data set or has aggregation,
    time consuming queries)
      option1: store view in original DB
      Option2 store view in read optimized DB
      tradeoff between extra space with cost.. The materialized view can be stores in same DB (then we dont manage updates to the new view) 
    or we can use some in memory cache or readonly DB that get created with data from source. 
    Progamaticalyl we can keep the view in readonly cache uptodate
  - 
- Service Discovery Pattern
  - Allows services to discover each other dynamically at runtime, often using a registry.
- Strangler Pattern
  - Gradually replaces parts of a legacy system with new microservices
- Bulkhead Pattern
  - Isolates different parts of the system to prevent a failure in one service from affecting others.
- Sidecar Pattern & Ambassador Pattern
  - Deploys auxiliary components or services alongside the main service to manage cross-cutting concerns like logging, monitoring, and security
  - Side Car Pattern
    - Extends the functionality of a service
    - No need to reimplement the logic in every programming language (hence multiple libraries one in each language are not needed)
    - No additional harware is required
    - isolation b/w sidecar and core application is acheived
    - It has accesss to same resources as core application so it can perfrom monitoring, logging, connect to registry, pull configs etc
  - Ambassador Side Car Pattern 
    - Only N/W related fucntons are extracted in the sidecar
    - this side car can perform
      - Retires
      - Disconnections
      - Authentication
      - Routing
      - Protocol version
- Health Check Pattern
  - Regularly checks the health and status of microservices to ensure they are functioning correctly.
- Retry Pattern
  - Automatically retries failed requests to handle transient failures
  -  thundering herd problem
    - he thundering herd problem occurs when a large number of processes or threads waiting for an event are awoken when
  that event occurs, but only one process is able to handle the event. When the processes wake up, they will each try 
  to handle the event, but only one will win. All processes will compete for resources, possibly freezing the computer,
  until the herd is calmed down again
    - Considerations. For Which errors shuold we retry?
      - errors which are short, Temporary and recoverable.
      - identify the delay.backoff strategy. Need to avoid Retry storm.
        - Fixed Delay
        - Incremental Delay
        - Exponential backoff. 
      - Adding Jitter or randomization between retries
      - How many times / how long to retry.
      - Is operation Idempotent
- Distributed Tracing Pattern
  - Tracks requests as they flow through the system to debug and monitor performance
- Anti-Corruption Adapter/Layer Pattern
  - Used when we built a new applicatoin out of old legacy system. This pattern allows to create new system in piece wise manner without breaking
  the product. So a new service is creates which sits b/w the new and old system and translated old-new and new-old conversation
    - Scenarios
      - Migration
        - Anti-corruption layer is temporary
      - Two Part System
        - Anti Corruption layer is permanent
- Backend for frontend
  - Scenario
    - we have both web and mobile FE. And one BE servers differnt APIs to these differenet FE. 
    - Split the BE into a BE for each FE. 
    - Common fucntions can be clubed in a new BE service and BFF can have only FE specific APIs. Thi swill avoid duplicating shared functionality
    Another approach is to use a shared library. But then who wil maintain it and it also tightly couples the BE with lib features. 
- Throttling and Rate Limiting Pattern
  - We can use AWS 'WAF' wbich defines Rules at ALB. This helps in DOS attacks
  - Then we can use Ingress Controller annotations to define Rate limiting thresholds
  - Overconsumption of resources in out system
    - Num of request to our services increases. This could cause issues. We have scale our application but the would add cost
    - We need to protect our service from Traffic Spikes
  - Overconsumption of resources of external API/ System
    - This coudl result in going over budget
      - Big data analysis. We can run a batch job which does data analysis. But it will need Storage, N/W resources and External ML service
      OVer use of these external resources couyld leed to a big Bill at the end of month
    - Soltution : Throttling and Rate limitting pattern 
      - Set limit on number of request per unit of time
      - Set Amount of data that can be sent/ received per unit of time.
      - Types of Throttling
        - Server Side Throttling
        - Client Side Throttling
      - how to implemet
        - Customer based or global (APi level) throttling
        - External throttling vs service based throttling
  - 
- DBAAS
- Pipes and Filter pattern