# springboot-activemq-demo

### start server

run DemoApplication#main()

### trigger message producer

> curl http://localhost:8089/trigger/{count} // count means how many messages will be produced.

one virtualTopic: `VirtualTopic.FOO.BAR`

### message listener

two consumer queues:

- `Consumer.CSA.VirtualTopic.FOO.BAR`
- `Consumer.SOME.VirtualTopic.FOO.BAR`

