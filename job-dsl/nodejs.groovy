job('My NodeJS First Job DSL') {
    scm {
        git('https://github.com/youhana-sobhy/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
	
	triggers{
		scm('H/5 * * * *')
	}
	wrappers{
		nodejs('nodejs')
	}
	steps{
		shell('npm install')
	}
	
}
