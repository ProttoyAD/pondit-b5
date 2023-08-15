# authorization-server-demo

## PrismJS Code Highlighting problem solution found in the following article
https://auralinna.blog/post/2017/code-syntax-highlighting-with-angular-and-prismjs

# Kubectl commands
1. `kubectl get pods` -  See all pods in current / default namespace
2. `kubectl run {pod_name} --image={image_name} {...additional params}` - creates a pod with some name, specified image, and additional parameters
3. `kubectl edit pod {pod_name}` - edits a running pod
4. `kubectl delete pod {pod_name}` - deletes a running pod
5. `kubectl describe pod {pod_name}` -  we can see details of the pod, which image is used, pod name, current state, IP/ports using, replicas etc
6. `kubectl apply -f pod_manifest_file.yaml` - Create a pod from pod manifest file
7. `kubectl replace -f pod_manifest_file.yaml` - Replace a running pod after editing the pod; in this case pod manifest file can be stored and found in the /temp/ folder