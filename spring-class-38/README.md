# authorization-server-demo

## PrismJS Code Highlighting problem solution found in the following article
https://auralinna.blog/post/2017/code-syntax-highlighting-with-angular-and-prismjs

# Kubectl commands
1. `kubectl get ns` - See all namespaces
2. `kubectl config get-context` - Find currently active namespace in current profile
3. `kubectl config set-context --current --namespace=<namespace name>` - Set current namespace to the provided namespace name
4. `kubectl get pods` -  See all pods in current / default namespace
5. `kubectl run {pod_name} --image={image_name} {...additional params}` - creates a pod with some name, specified image, and additional parameters
6. `kubectl edit pod {pod_name}` - edits a running pod
7. `kubectl delete pod {pod_name}` - deletes a running pod
8. `kubectl describe pod {pod_name}` -  we can see details of the pod, which image is used, pod name, current state, IP/ports using, replicas etc
9. `kubectl apply -f <object-manifest-file>.yaml` - Create kubernetes object(s) from manifest file
10. `kubectl replace -f pod_manifest_file.yaml` - Replace a running pod after editing the pod; in this case pod manifest file can be stored and found in the /temp/ folder
11. `kubectl logs <pod_name>` to see the logs inside a running pod
12. `kubectl exec -it <pod_name> -n <namespace> -- /bin/bash` to get inside the shell of a pod

# Kubernetes Objects writing format
Most of the kubernetes objects commonly have the following 4 root level properties:
```
apiVersion:
kind:
metadata:
spec:
```
Few objects like, namespace, configMap, secret etc may not have them all though. 

