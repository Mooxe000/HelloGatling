#!/usr/bin/env bash

set -e

dir_name='HelloGatling'
img_name="mooxe/scala"

docker run \
  --name=$dir_name \
  --rm \
  -ti \
  -v $PWD:/root/$dir_name \
  $img_name \
  /bin/bash
