#!/bin/sh

case "$1" in
  start)
    /usr/bin/aesdsocket -d &
    ;;
  stop)
    killall aesdsocket || true
    ;;
  restart)
    killall aesdsocket || true
    /usr/bin/aesdsocket -d &
    ;;
esac

exit 0

