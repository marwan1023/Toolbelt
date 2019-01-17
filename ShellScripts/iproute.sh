iptables -A PREROUTING -t nat -i eth0 -p tcp --dport 80 -j REDIRECT --to-port 8080

#iptables -D PREROUTING -t nat -i etho -p tcp --dport 80 -j REDIRECT --to-port 8080 
