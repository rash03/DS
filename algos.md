- BFS
- Two heaps
- Two Pointers
- Sliding Windows
- DFS
- Topological Sort
- Merge intervals
- Backtracking
- Trie
- Flood Fill
- Segment Tree
- Token bucket Algorithm

As you know my name is RS. I have total 18.5 years of experience. Ive been in AA for around x years now. Before that i was in BB for y years and befor that i was in CC, which is a service based company, for c years.
My designation in AA is Senior System Architect. My roles and responsibilities include working in the capacity of an Application Architect, Security Architect, and Individual Contributor.
I am responsible for d products in billing domain. I design and Implement functional, Non-functional and security related features. As an individual contributor im also involved in doing POCs driven by Customer enhancments/ architecutral and technology changes. I also act as a Security SME, where i participate in customer meetings, understand their products and security requirements and consult them how integration can happen. The main work in security revolve around user authN and AuthZ and service to service authn and AuthZ.

Im looking for Career growth and i also want to explore other Domains.

I have been with my current company for a years,I have worked hard to align my career goals with the company's objectives.
Now i also want to explore other options which can help in my long term aspirations and also expose me to new domains

I aim to function as an architect who can integrate various products from different domains to deliver a seamless experience to customers. This involves
identifying gaps in the current product suite,
selecting technologies to fill these gaps, and
defining flexible processes and deployment schemas to onboard customers from diverse business areas.

NFRs
1. audit logs
2. Monitoring using prometheus/ grafana
3. swagger UI authentication
4. Release  Note service
5. Support 10K request per sec for our AGS proxy
6. Docker image requirements
7. CI for cloud and non-cloud builds using Jenkins & gitlab-ci
8. Security NFR like http headers, token content and user-info management
9. k8 NFR like pod affinity /anti affinity labels for k8 entities
10. SVT for each product

challenging architecture design
    - AGS
    - Soap Module\

i implemented Soap Module backend independently. Challenge 1 was to reimplement it using latest tech / frameworks keeping old functionality as is
No document can cover all functionality and no one knows for sure that customers are using which features in what way. So the pressure was to PORT the code in new implementation
But it was not possible.

2. dsigned and implemented applicatiaon security across 2 boundary services and 5 web apps for Billing domain. laid down the guidelines and processed on how authN and AuthZ needs to be done.OAuth2 auth code flow using BE service was reuired.
3. Performance issue was addressed across 5 web apps. the SLA which customer wanted was max 3 sec for a page to load.
   After analysis the bottle neck was identified as catalog and reference data, They has more get calls as compared to put or post.
   using microservice pattern , I Extracted catalog and reference data in a separate no sqlDB and with an eventual consistency of 1 min.
4. Implemented a kafka streams application. The requirement was to convert sync calls to asyunc calls. Challenge came with the sequencing of calls. There is no corelation id and child record can come before parent record.
4. In moniotoring and infra services like nexus, jenkins, Grafana, graylog etc there is requirement for OIDC integration with customer IDP. Since these are opensoured product, and plugins for OIDC are paid i designed and implemented custom plugin using which how OIDC integration can happen. This impacts all customer deployment
3. Transaction limit was a special authZ req in few web apps
7. Created Release Note application indepently
8. I 
