### performance improvement of cache memory

this project belongs to my computer architecture course and aims to indicate the impact of adding a specialized cache to a Direct Mapped Cache, by comparing the hit ratio.
cache simulation is implemented in java.

at first we produce some random addresses and store them in 5 different file. these addresses have both, temporal and special locality.
then we implement a victim cache as a specialized cache and calculate the hit ratio.
results showed that hit ratio of Direct Mapped Cache is about 68% but by adding victim cache, hit ratio increses to 85%.
the victim cache in this project is a fully associated, 256 byte with LRU replacement policy.


### the block diagram of this system, is shown bellow:
![image](https://user-images.githubusercontent.com/44861408/134782322-cb3543e2-8693-44cb-b39b-4501e7750faa.png)

