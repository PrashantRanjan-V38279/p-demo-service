#"artifatName" will get replaced with exact artifact name validating from target directory of build.
FROM dtr-dev.nt.lab.com/admin/javabaseimage
EXPOSE 80
LABEL traefikbasepath="<traefikbasepath>" servicecertificatename="<servicecertificatename>" 
ADD target/artifactName /artifactName
CMD [ "java", "-javaagent:/appserveragent-v4.1.8.13/javaagent.jar", "-Dappdynamics.agent.tierName=<serviceName>", "-Dappdynamics.agent.reuse.nodeName=true", "-Dappdynamics.agent.reuse.nodeName.prefix=<serviceName>", "-jar", "-Dfile.encoding=UTF-8", "/artifactName" ]