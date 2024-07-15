**Design Usecases**
- Video Sharing - system design
- Map Reduce example
- Saga Example using apaceh camel : TODO how to scale orchestrator - ticket selling service
- Online education Platform : materialized view pattern
- CQRS example - Online store.
- CQRS with Materialized View for microservice 
  Usecase is related to scenario where we have more than one service each having its own DB and we have both Command and query Actions across all.
  - Problems with DB per micorservice
    - Joins operations are slow
    - In microservice, data is fetched from differnet Services and aggregated. This adds overhead
  - Solution :
    - CQRD  + Materialized View Pattern
      - apply CQRS => create a Query Service. Create a materialzed(mView) view from table fropm both DB
        - T osync the data to mView a broker can be used by 2 microservice(m-s). Service will publish change events, 
        query service subscribes to it and make changes in its mView
        - Another option to sync data is to use a cloud-Function (λ)