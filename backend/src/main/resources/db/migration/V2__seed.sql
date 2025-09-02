INSERT INTO org(name) VALUES ('Demo Org') ON CONFLICT DO NOTHING;

INSERT INTO project(org_id, name)
SELECT id, 'Demo Project'
FROM org WHERE name='Demo Org'
ON CONFLICT DO NOTHING;

INSERT INTO environment(project_id, name, sdk_key)
SELECT p.id, 'Development', 'dev-000000'
FROM project p
JOIN org o ON o.id=p.org_id AND o.name='Demo Org'
ON CONFLICT DO NOTHING;

INSERT INTO feature_flag(project_id, key, description, enabled, rollout_percentage, allowlist)
SELECT p.id, 'welcome-banner', 'Show welcome banner', true, 50, 'alice,bob'
FROM project p
JOIN org o ON o.id=p.org_id AND o.name='Demo Org'
ON CONFLICT DO NOTHING;