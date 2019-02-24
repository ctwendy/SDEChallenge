## Design diagram
Underneath is a simplae design diagram.
![design_diagram](https://github.com/ctwendy/SDEChallenge/blob/wendy/paytm-code-exercise/design_diagram.jpeg)

## Requirements

1. Handle large write volume: Billions of write events per day.
> To handle large write volume, there are multiple layers to help this aspect.
> Multiple threading inside single service both on front-end and back-end side.
> Ultilize distributed system to distribute loads across multiple services. Kubernetes could be one of good tools to help easily manage multiple serivces. It also make scaling easier.
> Using hbase as database. Hbase in memory caching and flush later machansim should help with large volume of write.

2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
> on service side, multiple services and inside multi threading could help handle large read/query faster.
> Since it's time-series metrics, it's also possible to run some batch jobs at off peak time to calculate in advance metrics for future user queries.
> Hbase strictly consistent realtime access aleady help a lot on the queries time but they could further integrate with mutiple tools for further help the querying and analyzing time (i.e. spark, pig, hive...)

3. Provide metrics to customers with at most one hour delay.
> The batch processes could help ready the metrics in advance.
> setup cluster in the same region for user could also help further reduce network/data transmit time. Or setup proxy service to help reduce duplicate calls or multiple transmit connections.
> Multi-threading in services to help parallel the load of analyzing data, hbase integrate spark and pig could also help reduce querying time and optimize analyzing processing time.

4. Run with minimum downtime.
> kubernetes help maintain desire state with minimum downtime. We could further try to schedule pods across multiple nodes/regions to further guarantee services uptime.

5. Have the ability to reprocess historical data in case of bugs in the processing logic.
> hbase replicaset will help maintain multiple copies.
> We could further run backup process on schedule to provide another layer of protection. hbase bottom using HDFS (Hadoop Distributed File System) allow backup process easy and fast.
