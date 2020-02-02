#!/bin/bash

set -e
set -u

build() {
  mvn $1 clean package
}

showUsage() {
  echo "Usage: $0 {bank|ccard}"
  exit
}

if [ "$#" -ne 1 ]; then
    showUsage
fi

case $1 in
  bank)
    build -Pbank
    ;;
  ccard)
    build -Pccard
    ;;
  *)
    showUsage
    ;;
esac