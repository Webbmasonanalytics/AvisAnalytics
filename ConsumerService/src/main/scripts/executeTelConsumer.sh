INSTALLATION_DIR=~/WebbmasonWS/AvisProjects/AvisAnalytics
mkdir -p $INSTALLATION_DIR
cd $INSTALLATION_DIR
git pull origin TestingRawTelemtry
cd $INSTALLATION_DIR/ConsumerService
mvn clean install

if [ $# -eq 0 ]
  then
    echo "Usage: ./executeTelConsumer.sh --avis.cdc.topics=<TOPIC-NAME> --group.id=[GroupID] --telemetry.test.NMZ.nulls=[true/false]"
fi

java -jar $INSTALLATION_DIR/ConsumerService/target/ConsumerService-1.0-SNAPSHOT.jar "$@"