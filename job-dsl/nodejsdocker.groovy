job('build_test_packge_docker'){
	scm{
		git('https://github.com/youhana-sobhy/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
	}
	
	triggers{
		scm('H/5 * * * *')
	}
	wrappers{
		nodejs("nodejs")
	}
	
	steps {
        dockerBuildAndPublish {
            repositoryName('minaalfons2018/docker-course-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('docker-hub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
	
}
