INSTALLATION_DIR=~/WebbmasonWS/AvisProjects
CONSUMER_SERVICE_DIR=$INSTALLATION_DIR/AvisAnalytics/ConsumerService

echo "*** CREATING INSTALLATION DIRECTORY $INSTALLATION_DIR ****"

mkdir -p $INSTALLATION_DIR

cd $INSTALLATION_DIR

git clone -b TestingRawTelemtry https://github.com/Webbmasonanalytics/AvisAnalytics.git

cd $CONSUMER_SERVICE_DIR

mvn clean install

if [ $# -eq 0 ]
  then
    echo "Usage: ./executeTelConsumer.sh --avis.cdc.topics=<TOPIC-NAME> --group.id=[GroupID] --telemetry.test.NMZ.nulls=[true/false] -Dspring.profiles.active=[NMZ-PREPROD/DEV/PROD/PREPROD]"
    exit;
fi

java -jar $CONSUMER_SERVICE_DIR/target/ConsumerService-1.0-SNAPSHOT.jar "$@"