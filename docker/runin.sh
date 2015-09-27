#!/usr/bin/env bash

set -e

dir_name='scala'
img_name="mooxe/${dir_name}"

docker run \
  --name=$dir_name \
  --rm \
  -ti \
  -v $PWD:/root/$dir_name \
  $img_name \
  /bin/bash
