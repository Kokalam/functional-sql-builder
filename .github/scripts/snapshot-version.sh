#!/bin/bash

current_version=$1

if [[ "$current_version" == *"BETA"* ]]; then
	split_version=(${current_version//-BETA-/ })
	beta_version=$((${split_version[1]} + 1))
	new_version="${split_version[0]}-BETA-${beta_version}"
	echo $new_version
else
	new_version="${current_version}-BETA-1"
	echo $new_version
fi
