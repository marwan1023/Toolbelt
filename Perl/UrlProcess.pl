#!/usr/bin/perl
use warnings;
use strict;
use LWP::Simple;
 
sub find_string
{
my ($file, $string) = @_;
open my $fh, '<', $file;
while (<$fh>) {
    #return 1 if /\Q$string/;
    if (/\Q$string/)
    {
         return $string;
    }
      
}
die "Unable to find string: $string";
}


my $filename = 'uids.txt';
 
open(FH, '<', $filename) or die $!;
 
while(<FH>){
   print $_;
}
close(FH);

my $url = "http://wabophoto.com/#about";
my $content = get($url);
#print $content
#$content =~ s/ /%20/g;

my $value = find_string('output.txt', '="generator');

my $real_value  = substr $value, 2, length($value);


print $real_value;








 
