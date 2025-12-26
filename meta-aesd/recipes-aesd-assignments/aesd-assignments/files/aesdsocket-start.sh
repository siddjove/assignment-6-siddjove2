#!/bin/sh
### BEGIN INIT INFO
# Provides:          aesdsocket
# Required-Start:    $network
# Required-Stop:     $network
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: AESD Socket Server
### END INIT INFO

PATH=/sbin:/bin:/usr/sbin:/usr/bin
DAEMON=/usr/bin/aesdsocket

case "$1" in
  start)
    echo "Starting aesdsocket"
    if pidof aesdsocket > /dev/null 2>&1; then
      echo "aesdsocket already running"
      exit 0
    fi

    if [ -x "$DAEMON" ]; then
      $DAEMON -d
      exit 0
    else
      echo "aesdsocket binary not found"
      exit 1
    fi
    ;;
  stop)
    echo "Stopping aesdsocket"
    pid=$(pidof aesdsocket)
    if [ -n "$pid" ]; then
      kill "$pid"
    fi
    ;;
  restart)
    $0 stop
    sleep 1
    $0 start
    ;;
  *)
    echo "Usage: $0 {start|stop|restart}"
    exit 2
    ;;
esac

exit 0

