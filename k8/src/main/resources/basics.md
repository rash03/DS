Master and worker node.
master node has etc server which stores info about the cluster. 
kube scheduler which schedules applications or container on node.
we have differnet controllers which tqkes care of different functaoinas like node controler , replication controler etc
we have kube-api server which performs all orchestration all operartions with in the cluster.

On worker node we have kubelet which listen to isntructions from api-server and manages container 
and kube-proxy which enables communication b/w services within the cluster.