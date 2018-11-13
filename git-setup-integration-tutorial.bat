echo off
echo # integration-tutorial >> README.md
echo .idea >> .gitignore
echo target >> .gitignore
echo *.iml >> .gitignore
echo .scannerwork >> .gitignore
echo *.log >> .gitignore
echo git-setup-spring-cloud-tutorial.bat >> .gitignore

git init
git add README.md
git add .gitignore
git commit -m "init integration-tutorial project"
git remote add origin https://github.com/samanalishiri/integration-tutorial.git
git push -u origin master

git add .
git commit -m "add source project"
git push -u origin master