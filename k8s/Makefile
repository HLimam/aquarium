create_cluster:
	eksctl create cluster --name aquarium-cluster --version 1.22 --region eu-west-1 --nodegroup-name linux-nodes --node-type t2.micro --nodes 4

delete_cluster:
	eksctl delete cluster aquarium-cluster

describe_cluster:
	eksctl utils describe-stacks --region=eu-west-1 --cluster=aquarium-cluster --node-type t2.micro --nodes 4

aws_identity:
	aws sts get-caller-identity

set_context:
	eksctl utils write-kubeconfig --cluster=aquarium-cluster --set-kubeconfig-context=true

enable_iam_sa_provider:
	eksctl utils associate-iam-oidc-provider --cluster=aquarium-cluster --approve

create_cluster_role:
	kubectl apply -f https://raw.githubusercontent.com/kubernetes-sigs/aws-alb-ingress-controller/v1.1.4/docs/examples/rbac-role.yaml

create_iam_policy:
	aws iam create-policy --policy-name AWSLoadBalancerControllerIAMPolicy --policy-document file://role/iam_policy.json

create_service_account:
	eksctl create iamserviceaccount --cluster=aquarium-cluster --namespace=kube-system --name=aws-load-balancer-controller --attach-policy-arn=arn:aws:iam::XXXXXXXXXX:policy/AWSLoadBalancerControllerIAMPolicy --override-existing-serviceaccounts --approve

add_graphical_ref_eks_to_helm:
	helm repo add eks https://aws.github.io/eks-charts

install_TargetGroupBinding:
	kubectl apply -k "github.com/aws/eks-charts/stable/aws-load-balancer-controller//crds?ref=master"

install_graphical_helm:
	helm install aws-load-balancer-controller eks/aws-load-balancer-controller --set clusterName=aquarium-cluster --set serviceAccount.create=false --set region=eu-west-1 --set vpcId=vpc-XXXXXXXX --set serviceAccount.name=aws-load-balancer-controller -n kube-system

deploy_ingress_controller:
	kubectl apply -f role/v2_4_2_full.yaml

deploy_application:
	kustomize build ./k8s | kubectl apply -f -

delete_application:
	kustomize build ./k8s | kubectl delete -f -

