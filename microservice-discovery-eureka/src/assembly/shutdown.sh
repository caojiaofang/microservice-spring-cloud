#!/bin/sh
#要杀死的端口号
port=8761
#根据端口号查询对应的pid
pid=$(netstat -nlp | grep :$port | awk '{print $7}' | awk -F"/" '{ print $1 }');

printf " ==== Stopping:$pid ==== \n\n"

#杀掉对应的进程，如果pid不存在，则不执行
if [  -n  "$pid"  ];  then
    kill  -9  $pid;
else
	printf " ==== $port is Stop ==== \n\n"
fi