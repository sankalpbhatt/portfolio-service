if [ -z "$1" ]
  then
    echo "-> Please provide file name"
    exit 1
fi

folder_name='../db/migrations/'
file_name=${1}
while getopts :s opt
do
  case ${opt} in
    s)
      if [ -z "$2" ]
        then
          echo "-> Please provide file name"
          exit 1
      fi
      folder_name='../db/seed/'
      file_name=${2}
  esac
done

time_stamp=$(date +%s)
file_path="${folder_name}V${time_stamp}__${file_name}.sql"
touch "$file_path"
echo "Migration file created at $file_path"
