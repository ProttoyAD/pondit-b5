## Git commands


	1. git init - to initialize an empty repository
	2. git status - to view the status and branch information of a repository
	3.git add "file_name" to add some file in staging. To add all files, use git add . ( . = all in current git tracking)
    4. git remove "file_name" to remove from staging
    5. git commit -m "some message" - to commit a file and clean git working tree
    6. git remote add <alias_name> <repo_url> - To introduce some remote repository to local
    7. git pull <repository> <branch> to pull from remote
    8. git push <repository> <branch> to push to some branch in remote
    9. git pull --allow-unrelated-histories to allow unrelated histories
    10. git branch --set-upstream-to=<alias_name>/<remote_branch_name> <local_branch_name> - to connect some local branch to the upstream branch